package com.example.apcheignite;

import org.apache.ignite.client.IgniteClient;
import org.apache.ignite.sql.BatchedArguments;
import org.apache.ignite.sql.ResultSet;
import org.apache.ignite.sql.SqlRow;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class con {



    @GetMapping("/test")
    public String test() {

        try (IgniteClient client = IgniteClient.builder()
                .addresses("127.0.0.1:10800")
                .build()
        ) {
            client.sql().execute(null, "CREATE TABLE IF NOT EXISTS Person (id int primary key, name varchar, age int);");


            long rowsAdded = Arrays.stream(client.sql().executeBatch(null,
                            "INSERT INTO Person (id, name, age) values (?, ?, ?)",
                            BatchedArguments.of(1, "John", 46)
                                    .add(2, "Jane", 28)
                                    .add(3, "Mary", 51)
                                    .add(4, "Richard", 33)))
                    .sum();

            try (ResultSet<SqlRow> rs = client.sql().execute(null, "SELECT id, name, age FROM Person")) {
                while (rs.hasNext()) {
                    SqlRow row = rs.next();
                    System.out.println("    "
                            + row.value(1) + ", "
                            + row.value(2));
                }
            }
        }



        return "test";
    }
}
