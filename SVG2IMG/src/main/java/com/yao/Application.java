package com.yao;


import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

import java.io.IOException;

/**
 * Creator: Yao
 * Date:    2018/7/3
 * For:
 * Other:
 */
public class Application {

    public static void main(String[] args) throws IOException {

        // check
        Assert.isTrue(args.length > 0, "args.svg is not support");

        // init
        String url = args[0];

        System.out.printf("READ.SVG= \n\t%s", readSVG2XML(url));
    }

    /****
     * 尝试加载、读取第一个 SVG 的动画
     * @param url
     * @return
     * @throws IOException
     */
    public static String readSVG2XML(String url) throws IOException {

        // check
        Assert.isTrue(StringUtils.isNotBlank(url), "svg.path is not support");

        // init
        WebClient client = new WebClient();
        HtmlPage page = client.getPage(url);

        // read
        client.waitForBackgroundJavaScript(1000);
        DomNodeList<DomElement> list = page.getElementsByTagName("svg");
        Assert.isTrue(list.size() > 0, "svg element not found");

        return list.get(0).asXml();
    }
}
