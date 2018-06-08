package com.thomas.products.sqlbuider;

import com.healthmarketscience.sqlbuilder.*;
import org.apache.ibatis.jdbc.SQL;

public class OpenHMSSQLBuilder {

    public static void main(String[] args) {
        OpenHMSSQLBuilder sqlBuilder = new OpenHMSSQLBuilder();
//        System.out.println(sqlBuilder.starSelectSQL());
//        System.out.println(sqlBuilder.unionSQL(sqlBuilder.starSelectSQL(), sqlBuilder.starSelectSQL()));
        System.out.println(sqlBuilder.complexSelectSQL(sqlBuilder.unionSQL(sqlBuilder.starSelectSQL(), sqlBuilder.starSelectSQL())));
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
    private SelectQuery starSelectSQL() {
        SelectQuery selectQuery =
                new SelectQuery()
                        .addCustomColumns(
                                new CustomSql("fact_a.dt as dt"),
                                new CustomSql("dim_a.d1_id as d1_id"),
                                new CustomSql("dim_a.d1_name as d1_name"),
                                new CustomSql("dim_b.d2_id as d2_id"),
                                new CustomSql("dim_b.d2_name as d2_name"),
                                new CustomSql("sum(fact_a.ord_num) as ord_num"))
                        .addCustomJoin(SelectQuery.JoinType.LEFT_OUTER, "waimai_mart.fact_a as fact_a",
                                "waimai_mart.dim_a as dim_a",
                                BinaryCondition.equalTo(new CustomSql("fact_a.d1_id"),
                                        new CustomSql("dim_a.d1_id")))
                        .addCustomJoin(SelectQuery.JoinType.LEFT_OUTER, "waimai_mart.fact_a as fact_a",
                                "waimai_mart.dim_b as dim_b",
                                BinaryCondition.equalTo(new CustomSql("fact_a.d2_id"),
                                        new CustomSql("dim_b.d2_id")))
                        .addCondition(new InCondition("dt",
                                "#{dt}"))
                        .addCustomGroupings(new CustomSql("fact_a.dt"),
                                new CustomSql("dim_a.d1_id"),
                                new CustomSql("dim_a.d1_name"),
                                new CustomSql("dim_b.d2_id"),
                                new CustomSql("dim_b.d2_name"))
                        ;
        return selectQuery;
    }

    private String complexSelectSQL(Query subQuery) {
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

    private Query unionSQL(SelectQuery... sqls) {
        return new UnionQuery(SetOperationQuery.Type.UNION_ALL, sqls);
    }
}
