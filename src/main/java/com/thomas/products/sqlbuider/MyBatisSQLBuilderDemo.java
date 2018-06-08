package com.thomas.products.sqlbuider;

import org.apache.ibatis.jdbc.SQL;

public class MyBatisSQLBuilderDemo {

    private static final String UNIONALL = " union all ";

    public static void main(String[] args) {
        MyBatisSQLBuilderDemo sqlBuilder = new MyBatisSQLBuilderDemo();
//        System.out.println(sqlBuilder.simpleSelectSQL());
//        System.out.println(sqlBuilder.unionSQL(sqlBuilder.simpleSelectSQL(), sqlBuilder.simpleSelectSQL()));
        System.out.println(sqlBuilder.complexSelectSQL(sqlBuilder.unionSQL(sqlBuilder.simpleSelectSQL(), sqlBuilder.simpleSelectSQL())));
    }


    /**
     * select f.dt as dt,
     * d1.c1 as c1,
     * d1.c1_name as c1_name,
     * d2.c2 as c2,
     * d2.c2_name as c2_name,
     * sum(f1.ord_num) as ord_num,
     * 0 as poi_num
     * from 事实表1 as f
     * left join 维度表1 as d1
     * on f.dt=d1.dt
     * and f.c1=d1.c1
     * left join 维度表2 as d2
     * on f.dt=d2.dt
     * and f.c2=d2.c2
     * where f.dt between '20180101' and '20180107'
     * and d1.c3=1
     * group by f.dt,
     * d1.c1,
     * d1.c1_name,
     * d2.c2,
     * d2.c2_name
     *
     * @return
     */
    private String simpleSelectSQL() {
        SQL sql = new SQL();
        sql.SELECT("fact_a.dt as dt")
                .SELECT("dim_a.d1_id as d1_id")
                .SELECT("dim_a.d1_name as d1_name")
                .SELECT("dim_b.d2_id as d2_id")
                .SELECT("dim_b.d2_name as d2_name")
                .SELECT("sum(fact_a.ord_num) as ord_num")
                .FROM("waimai_mart.fact_a as fact_a")
                .LEFT_OUTER_JOIN("waimai_mart.dim_a as dim_a on fact_a.d1_id=dim_a.d1_id")
                .LEFT_OUTER_JOIN("waimai_mart.dim_b as dim_b on fact_b.d2_id=dim_b.d2_id")
                .WHERE("dt=#{dt}")
                .GROUP_BY("dim_a.d1_id")
                .GROUP_BY("dim_a.d1_name")
                .GROUP_BY("dim_b.d2_id")
                .GROUP_BY("dim_b.d2_name");
        return sql.toString();
    }

    private String complexSelectSQL(String subQuery) {
        SQL sql = new SQL();
        sql.SELECT("t.dt as dt")
                .SELECT("t.d1_id as d1_id")
                .SELECT("t.d1_name as d1_name")
                .SELECT("t.d2_id as d2_id")
                .SELECT("t.d2_name as d2_name")
                .SELECT("sum(t.ord_num) as ord_num")
                .FROM("(" + subQuery + ") as t")
                .GROUP_BY("t.d1_id")
                .GROUP_BY("t.d1_name")
                .GROUP_BY("t.d2_id")
                .GROUP_BY("t.d2_name");
        return sql.toString();
    }

    private String unionSQL(String... sqls) {
        StringBuilder sql2 = new StringBuilder();
        for (String sql : sqls) {
            sql2.append("(").append(sql).append(")").append(UNIONALL);
        }
        sql2.setLength(sql2.length() - UNIONALL.length());
        return sql2.toString();
    }
}
