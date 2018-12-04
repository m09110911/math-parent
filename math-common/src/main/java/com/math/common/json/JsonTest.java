package com.math.common.json;


import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class JsonTest {
    public static void main(String[] args) throws IOException {
        List<Node> nodes = new ArrayList<>();
        nodes.add(new Node(111, "TEST1"));
        nodes.add(new Node(112, "TEST2"));
        nodes.add(new Node(113, "TEST3"));
        nodes.add(new Node(114, "TEST4"));
        nodes.add(new Node(115, "TEST5"));
        nodes.add(new Node(116, "TEST6"));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        JsonSerializer jsonSerializer = new JsonSerializer(out);
        jsonSerializer.outPrint(nodes);

        System.out.println(new String(out.toByteArray(), StandardCharsets.UTF_8));
    }

}
