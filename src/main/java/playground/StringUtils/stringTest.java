package playground.StringUtils;

public class stringTest {
    public static void main(String[] args){
        String result;
        String test = "create or replace PROCEDURE TN_EXCHANGE_USERID(IN_OLD_ID IN VARCHAR2, p_IN_NEW_ID IN VARCHAR2) IS v_query VARCHAR2(1000);\n" +
                "  BEGIN\n" +
                "    v_query := '';\n" +
                "    FOR x IN (SELECT owner, table_name, column_name\n" +
                "              FROM all_tab_columns\n" +
                "              where column_name like 'CREATE_USER_ID'\n" +
                "                AND OWNER = (select user from dual)\n" +
                "                AND TABLE_NAME LIKE 'TN_%'\n" +
                "                AND table_name NOT IN (select view_name from user_views)) LOOP v_query :=\n" +
                "                                                                               v_query || 'update ' || x.owner || '.' ||\n" +
                "                                                                               x.table_name ||\n" +
                "                                                                               ' set CREATE_USER_ID =:p_IN_NEW_ID where CREATE_USER_ID =:IN_OLD_ID';\n" +
                "      EXECUTE IMMEDIATE v_query using p_IN_NEW_ID, IN_OLD_ID;\n" +
                "      commit;\n" +
                "      v_query := '';\n" +
                "    END LOOP;\n" +
                "\n" +
                "    FOR x IN (SELECT owner, table_name, column_name\n" +
                "              FROM all_tab_columns\n" +
                "              where column_name like 'CHARGER_ID'\n" +
                "                AND OWNER = (select user from dual)\n" +
                "                AND TABLE_NAME LIKE 'TN_%'\n" +
                "                AND table_name NOT IN (select view_name from user_views)) LOOP v_query :=\n" +
                "                                                                               v_query || 'update ' || x.owner || '.' ||\n" +
                "                                                                               x.table_name ||\n" +
                "                                                                               ' set CHARGER_ID =:p_IN_NEW_ID where CHARGER_ID =:IN_OLD_ID';\n" +
                "      EXECUTE IMMEDIATE v_query using p_IN_NEW_ID, IN_OLD_ID;\n" +
                "      commit;\n" +
                "      v_query := '';\n" +
                "    END LOOP;\n" +
                "\n" +
                "    FOR x IN (SELECT owner, table_name, column_name\n" +
                "              FROM all_tab_columns\n" +
                "              where column_name like 'UPDATE_USER_ID'\n" +
                "                AND OWNER = (select user from dual)\n" +
                "                AND TABLE_NAME LIKE 'TN_%'\n" +
                "                AND table_name NOT IN (select view_name from user_views)) LOOP v_query :=\n" +
                "                                                                               v_query || 'update ' || x.owner || '.' ||\n" +
                "                                                                               x.table_name ||\n" +
                "                                                                               ' set UPDATE_USER_ID =:p_IN_NEW_ID where UPDATE_USER_ID =:IN_OLD_ID';\n" +
                "      EXECUTE IMMEDIATE v_query using p_IN_NEW_ID, IN_OLD_ID;\n" +
                "      commit;\n" +
                "      v_query := '';\n" +
                "    END LOOP;\n" +
                "  END TN_EXCHANGE_USERID;";

        result = StringUtil.eraseWhiteSpace(test);

        System.out.println(result);
    }
}
