package org.vikastaneja.coderust;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vikastaneja on 3/31/14.
 */
public class Strings {

    /**
     *
     * @param str
     * @return
     */
    List<String> splitString(String str) {
        if (str == null)
            throw new NullPointerException("String is null.");

        if (str.length() == 0)
            return new ArrayList<String>();

        List<String> list = new ArrayList<String>();
        boolean split = true;
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            StringBuffer sb = new StringBuffer();
            if (ch[i] == '"' && split) {
                i++;
                split = false;
                while (i < ch.length && ch[i] != '"' )
                sb.append (ch[i++]);
                if (sb.length() != 0) list.add(sb.toString());
                split = true;

                continue;
            }
            else if (ch[i] == ' ' && split) {
                i++;
                while (i < ch.length && ch[i] != ' ' && split) {
                    if (ch[i] == '"') split = !split;

                    sb.append(ch[i++]);
                }

                if (sb.length() != 0) list.add(sb.toString());
            }
        }

        return list;
    }
}
