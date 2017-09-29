package com.yada.generator;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TemplateGenerator {

    private static String packageName = "com.yada.test";
    private static String modelName = "User";
    private static String modelClass = "com.yada.model.User";

    public static void main(String[] args) {

        VelocityEngine ve = new VelocityEngine();
        ve.setProperty("file.resource.loader.path", System.getProperty("user.dir"));
        ve.setProperty("input.encoding", "UTF-8");
        ve.setProperty("output.encoding", "UTF-8");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.init();

        Template dao = ve.getTemplate("./templates/dao.java.vm");
        Template query = ve.getTemplate("./templates/query.java.vm");
        Template service = ve.getTemplate("./templates/service.java.vm");
        Template serviceImpl = ve.getTemplate("./templates/serviceImpl.java.vm");
        VelocityContext ctx = new VelocityContext();
        ctx.put("package", packageName);
        ctx.put("model", modelName);
        ctx.put("author", System.getProperty("user.name"));
        ctx.put("date", new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

        merge(dao, ctx, "/dao", modelName + "Dao.java");
        merge(query, ctx, "/query", modelName + "Query.java");
        merge(service, ctx, "/service", modelName + "Service.java");
        merge(serviceImpl, ctx, "/service/impl", modelName + "ServiceImpl.java");
        System.out.println("success...");
    }

    private static void merge(Template template, VelocityContext ctx, String path, String fileName) {
        PrintWriter writer = null;
        try {
            String rootPath = System.getProperty("user.dir") + "/output" + path;
            File viewDir = new File(rootPath);
            if (!viewDir.exists()) {
                viewDir.mkdirs();
            }
            writer = new PrintWriter(rootPath + "/" + fileName);
            template.merge(ctx, writer);
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }
}
