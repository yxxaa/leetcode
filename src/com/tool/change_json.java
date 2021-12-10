package com.tool;

/**
 * @author yxx
 * @date 2021/10/28 15:42
 * @Description:
 */
public class change_json {
    public static void main(String[] args) {
        String s = "{eqpmtTp=Android, logonPswd=u0M4NBmU9wHmC7YSKSKH5I2n+Q5BXqkkcjstUqTiX97jiEn4rM4ELmiSSWuBYJXyw9OTIT1L90V/fz54+yg8h6iEfE1Z8GBqz80v/cY/YrmC6Mf/qTZhSQjbh6yQzRvtFuPNLr8, eqpmtModel=Redmi Note 8, mbphNuy=2}";
        String[] split = s.split(", ");
        StringBuilder stringBuilder = new StringBuilder();
        for (String a: split) {
            String[] split1 = a.split("=");
            stringBuilder.append("\"");
            stringBuilder.append(split1[0]);
            stringBuilder.append("\":\"" + split1[1] + "\",");
        }
        System.out.println(stringBuilder.toString());
    }
}
