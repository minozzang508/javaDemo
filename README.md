- ![#f03c15](https://placehold.it/15/f03c15/000000?text=+) `#f03c15`
- ![#c5f015](https://placehold.it/15/c5f015/000000?text=+) `#c5f015`
- ![#1589F0](https://placehold.it/15/1589F0/000000?text=+) `#1589F0`

# Graal VM
[발표 slide 자료](https://www.slideshare.net/taewanme/cloud-native-javagraalvm)와 Baeldung.com의 ['Deep Dive Intothe New Java JIT Compiler - Graal'](https://www.baeldung.com/graal-java-jit-compiler)글 내용입니다.

미칠듯이 요약하자면, Graal VM은 오라클이 기존 JVM 안에 있는 컴파일러를 더 좋게 만든 VM입니다.
뽀나스로 여러 언어 컴파일도 지원하고, *정성있게 만들었습니다.
### 1. keyword
    - Graal VM
        1996년 이후부터, 오라클에서 JAVA 3대 전환점 이후 중요한 전환점으로 밀고있는 Graal VM은 무엇일까요?
        JAVA의 변화를 살펴보면서 GraalVM등장까지를 살펴봅니다.
        
    - JVM
        기존 JVM 위에서 자바 소스코드가 실행되는 과정을 대충 파악하고 문제점을 알아본다면
        GraalVM 프로젝트가 나온 이유를 알 수 있것죠..?
        
    - JIT Compiler
        Graal (Graal VM이 아님!) 어쨋든 Graal은 JIT 컴파일러입니다.
        그럼 JIT 컴파일러는 무엇일까요?
    
    - Polyglot
        - 프로그램 하나를 여러가지 언어로 개발하는 것을 '폴리글랏'이라고 합니다.
        - Graal VM은 여러가지 언어를 오베드를 발생시키지 않고 지원합니다.

자바 주요 전환점
- 1999년 JAVA 1.2가 등장하면서 EE(Enterprise Edition)이 등장합니다. 애플릿을 비롯한 UI중심의 기능구현에서 JAVA가 본격적으로 엔터프라이즈 버전의 안정적인 기능 구현에 참여합니다.
- 2005년, JAVA EE 5.0이 등장하면서 POJO, DI 개념이 화두되면서 JAVA 진영에서 오픈소스 커뮤니티를 주도합니다.
- 2006년, OpenJDK 등장, JDK는 이전까지 기업에서 건드리지 않고 사용하는 도구였지만, OpenJDK가 등장하면서 이젠 아니라능..
- JAVA8이후, 함수형 프로그래밍 갈증 해소
- Graal VM 프로젝트로 JVM 성능 향상
    
## 기존 JVM
#### 2-1. JVM 에서 소스코드 실행과정

Graal VM을 알아보기 전에 기본적인 JVM 실행 방법을 알아보겠습니다.

![jvm](http://4dang.kr:8929/minorang9/Coca-Cola/raw/master/Java-program-execution.png)

1. *foo.java* 소스코드
2. javac 컴파일러가 바이트코드 (*foo.class*)로 Compile
3. java 명령어로 *foo.class*를 실행
    1. JVM 위에서 byte코드가 OS에 맞는 기계어로 번역하는데 *interprete*라고 합니다.
        1. 에러 및 악성 코드 검출
        2. 지정된 *foo.class*에서 main메서드를 호출

    평범한 인터프리터들은 대게 native code보다 느리기 때문에 JVM은 bytecode를 기계어로 컴파일하는 다른 컴파일러를 실행하는데 이걸 *JIT Compiler(Just-In-Time Compiler)* 라고 부릅니다.

#### 2-2. HotspotVM
기존 JIT Compiler는 HotspotVM이었습니다.
이놈의 구조와 특징을 간단히 본 뒤 본격적으로 GraalVM을 알아보죠.
- Oracle Java JVM
- Java SE 1.3 (99년도)에 추가
- C++로 개발했습니다. 당시에는 C, C++속도가 가장 빠르다고 여겨졌으니까요.
- 2개의 컴파일러로 구성
    * C1 : client compiler
        * 요놈은 빠르게 시작하는 대신에 최적화가 그다지 좋진 않습니다.
        
            ```
                $ java -client 
            ```
 
    * C2 : server compiler
        * 요놈은 C1이랑 반대겠죠? 최적화에 집중하는 놈입니다. 대신 웜업이 필요해 시작이 느립니다.

            ```
                $ java -server 
            ```

    여기서 말하는 '최적화'는 실행환경에서 더 빨리 실행할 수 있는 기계어를 생산하는 일을 말합니다.

##### Tiered Compilation
보통 프로그램을 실행할 때는 두개 다 사용합니다. 기본 JIT 컴파일 설정이란 소리죠.
만약에 수동으로 컴파일 설정을 변경하고 싶다면 다음과 같은 옵션을 추가해주시면 됩니다.
        
```
    -XX:+TieredCompilation
```
* 동작을 간단히 설명해보면,
    * C2는 웜업 단계가 필요합니다. 
    * 그래서 c1컴파일로 빠르게 실행하다가 양이 많아지면 C2 컴파일러가 컴파일을 맡게 됩니다.
    
##### HotspotVM의 한계(라 적어놓고 C2  컴파일러의 한계라 보면 됨)

AOT

C2 JIT 컴파일러는 수명이 다했다고 보면 됩니다.
코드 관리가 힘들기 때문에 몇년동안 주된 기능 향상이 없었고 현재 설계보다 더 나은 기능 향상이 힘들 것이라는게 학계의 정설입니다.

그래서 GraalVM이 등장하게 됩니다.
