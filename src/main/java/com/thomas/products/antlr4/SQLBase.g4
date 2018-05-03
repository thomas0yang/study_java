grammar SQLBase;

stat
    : select_clause
    ;

select_clause
    : SELECT column_list_clause FROM table_references # printSQLInfo
    ;

column_list_clause
    : column_name (COMMA column_name)*
    ;

column_name
    : ID # printColumnName
    ;

table_references
    : ID # printTableName
    ;

SELECT
    : 'select'
    ;

FROM
    : 'from'
    ;

COMMA
    : ','
    ;

ID
    : ( 'a' .. 'z' | 'A' .. 'Z' | '_' )+
    ;

WS
    : ( ' ' | '\t' | '\n' | '\r' )+ -> skip
    ;