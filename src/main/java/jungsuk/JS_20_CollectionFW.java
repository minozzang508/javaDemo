package jungsuk;

/**
 * Created by minho on 2017-07-11.
 */

/*
*
* 1. Collection Interface
*   - Collection <- List
*                <- Set
*     Map       * Map 인터페이스는 전혀 다른 형태로 컬렉션을 다루기 때문에 같은 상속계층도에 포함되지 못한다.
*
*  * Collection Framework를 분석하면 객체지향언어의 설계능력을 향상시킬 수 있다.
*
*       Method                                 설명
*   boolean add(Object o)                   지정된 객체 또는 컬렉션의 객체들을 Collection에 추가한다.
*   boolean addAll(Collection c)
*   void clear()                            Collection의 모든 객체를 삭제한다.
*   boolean contains(Object o)              지정된 객체 또는 컬렉션이 Collection에 포함되어 있는지 확인한다.
*   boolean containsAll(Collection c)
*   boolean equals(Object o)                동일한 Collection인지 비교.
*   int hashCode()                          HashCode 반환
*   Iterator iterator()                     Collection의 Iterator를 얻어서 반환한다.
*   boolean isEmpty()                       Collection이 비어있는지 확인한다.
*   boolean remove(Object o)                지정된 객체를 삭제한다.
*   boolean removeAll(Collection c)
*   boolean retainAll(Collection c)         지정된 Collection에 포함된 객체만을 남기고 다른 객체들은 Collection에서 삭제.
*                                           이 작업으로 Collection에 변화가 있으면 true, 아니면 false 반환.
*   int size()                              Collection에 저장된 객체 수 반환.
*   Object[] toArray()                      Collection에 저장된 객체를 객체배열로 반환.
*   Object[] toArray(Object[] a)            지정된 배열에 Collection의 객체를 저장해서 반환.
*
*
* 2. List - 순서가 있는 데이터의 집합. 중복 허용
*      ㄴ Vector <- Stack
*      ㄴ ArrayList
*      ㄴ LinkedList
*
*       Method                                      설명
*   void add(int index, Object element)         지정된 index에 객체 element 또는 Collection에 포함된 객체를 추가
*   void addAll(int index, Collection c)
*   int indexOf(Object o)                       지정된 객체의 index를 반환.
*   Object get(int index)                       지정된 index의 객체를 반환.
*   int lastIndexOf(Object o)                   지정된 객체의 index를 반환.(List의 마지막 요소부터 역방향 순회.)
*   ListIterator listIterator()                 List의 객체에 접근할 수 있는 ListIterator를 반환한다.
*   ListIterator listIterator(int index)
*   Object remove(int index)                    지정된 index의 객체를 삭제하고 삭제된 객체를 반환.
*   Object set(int index, Object element)       지정된 index에 element를 저장한다.
*   void sort(Comparator c)                     지정된 comparator(지정자)로 List를 정렬한다.
*   List subList(int fromIndex, int toIndex)    지정된 범위에 있는 객체를 반환.
*
*
* 3. Set - 순서가 없는 데이터의 집합. 중복 허용 X.
*     ㄴ HashSet
*     ㄴ SortedSet <- TreeSet
*
*
*
* 4. Map - Key-Value pair로 이루어진 데이터의 집합. 순서는 유지하지 않으며, 키는 중복을 허용하지 않고, 값은 중복을 허용.
*     ㄴ Hashtable
*     ㄴ HashMap <- LinkedHashMap
*     ㄴ SortedMap <- TreeMap
*
*       Method                                      설명
*   void clear()                                Map의 모든 객체를 삭제한다.
*   boolean containsKey(Object key)             지정된 key객체와 일치하는 Map의 key 객체가 있는지 확인한다.
*   boolean containsValue(Object value)         지정된 value객체와 일치하는 Map의 Value 객체가 있는지 확인한다.
*   Set entrySet()                              Map에 있는 key-value 쌍을 Map.Entry타입 객체로 저장한 Set으로 반환.
*   boolean equals(Object o)                    동일한 Map인지 비교한다.
*   Object get(Object key)                      지정된 key 객체에 대응하는 value객체를 찾아서 반환한다.
*   Set ketSet()                                Map에 있는 모든 key객체를 반환한다.
*   Object put(Object key, Object value)        Map에 value객체를 key객체에 mapping하여 저장한다.
*   void putAll(Map t)                          지정된 Map의 모든 key-value 쌍을 추가한다.
*   Object remove(Object key)                   지정된 key객체와 일치하는 key-value 객체를 삭제하고 반환한다.
*   int size()                                  Map에 저장된 key-value쌍의 개수를 반환한다.
*   Collection values()                         Map에 저장된 모든 value객체를 반환한다.
*
*
*   Map.Entry Interface : Map의 inner interface이다. key-value쌍을 다루기 위해 내부적으로 정의해 놓았다.
*
*         Method                                      설명
*   boolean equals(Object o)                    동일한 Entry인지 비교한다.
*   Object getKey()                             Entry의 key객체를 반환한다.
*   Object getValue()                           Entry의 value객체를 반환한다.
*   int hashCode()                              Entry의 해쉬코드를 반환한다.
*   Object setValue(Object value)               Entry의 value객체를 지정된 객체로 바꾼다.
*
* */
public class JS_20_CollectionFW {
}
