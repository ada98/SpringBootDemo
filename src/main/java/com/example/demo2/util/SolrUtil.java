package com.example.demo2.util;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

public class SolrUtil {
    public static void main(String[] args) throws Exception {
        solrQuery();
    }
    public static void solrQuery() throws Exception {
        String solrUrl = "http://192.168.72.128:8080/solr";
        SolrServer solrClient = new HttpSolrServer(solrUrl);
        // 创建搜索对象
        SolrQuery query = new SolrQuery();
        // 设置搜索条件
        query.set("q","category:2");
        // 分页参数
        query.setStart(0);
        // 设置每页显示多少条
        query.setRows(10);
        //发起搜索请求
        QueryResponse response = solrClient.query(query);
        // 查询结果
        SolrDocumentList docs = response.getResults();
        // 查询结果总数
        long count= docs.getNumFound();
        System.out.println("总条数为"+count+"条");
        for (SolrDocument doc : docs) {
            System.out.println("id:"+ doc.get("id") + ",name:"+ doc.get("name") + ",uuid:"+ doc.get("uuid"));
        }

    }

}
