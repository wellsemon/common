package com.semon.common.util;

import com.thoughtworks.xstream.XStream;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConvertUtil {
    public static String arrToStr(String... strarr) {
        StringBuilder sbuilder = new StringBuilder();
        for (String str : strarr) {
            sbuilder.append(str);
        }

        return sbuilder.toString();
    }

    public static Map<String, String> xmlToMap(InputStream ins) throws DocumentException, IOException {
        Map<String, String> map = new HashMap<String, String>();
        SAXReader reader = new SAXReader();            // 使用dom4j解析xml
        Document doc = reader.read(ins);

        Element root = doc.getRootElement();         // 获取根元素
        List<Element> list = root.elements();        // 获取所有节点

        for (Element e : list) {
            map.put(e.getName(), e.getText());
        }
        ins.close();

        return map;
    }

    /**
     * 将文本消息对象转换成XML
     */
    public static String toXMLStr(Class classobj, Object instance) {

        XStream xstream = new XStream();              // 使用XStream将实体类的实例转换成xml格式
        xstream.alias("xml", classobj); // 将xml的默认根节点替换成“xml”
        return xstream.toXML(instance);

    }
}
