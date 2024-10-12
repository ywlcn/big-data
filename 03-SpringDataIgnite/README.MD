# 説明
本サンプルは基本的に`https://www.gridgain.com/docs/tutorials/spring/spring-ignite-tutorial#start-the-apache-ignite-cluster-and-load-the-sample-database`を参考して作成していたものです。

# セットアップ
1. `./src/main/resources/signite-server-config.xml`　を利用してサーバを起動する。
2. `apache-ignite-2.16.0\bin>sqlline.bat -u "jdbc:ignite:thin://127.0.0.1/" -n ignite -p ignite --run=world.sql`で`./src/main/resources/sql/world.sql`のSQL文をサーバに導入する。
たまにサーバがinactive状態になる場合がある。その時に`apache-ignite-2.16.0\bin>control.bat --activate`を実施する。
3. `gradle bootrun`で起動する
4. 動作確認する


- `curl http://localhost:9003/api/cities?population=8000000`
    ```json
    [{"id":3793,"countryCode":"USA","name":"New York","district":"New York","population":8008278},
    {"id":3580,"countryCode":"RUS","name":"Moscow","district":"Moscow (City)","population":8389200},
    {"id":2515,"countryCode":"MEX","name":"Ciudad de México","district":"Distrito Federal","population":8591309},
    {"id":3357,"countryCode":"TUR","name":"Istanbul","district":"Istanbul","population":8787958},
    {"id":2822,"countryCode":"PAK","name":"Karachi","district":"Sindh","population":9269265},
    {"id":939,"countryCode":"IDN","name":"Jakarta","district":"Jakarta Raya","population":9604900},
    {"id":1890,"countryCode":"CHN","name":"Shanghai","district":"Shanghai","population":9696300},
    {"id":206,"countryCode":"BRA","name":"São Paulo","district":"São Paulo","population":9968485},
    {"id":2331,"countryCode":"KOR","name":"Seoul","district":"Seoul","population":9981619},
    {"id":1024,"countryCode":"IND","name":"Mumbai (Bombay)","district":"Maharashtra","population":10500000}]
    ```


- `curl http://localhost:9003/api/cities/mostPopulated?limit=10`
    ```json
    [["Mumbai (Bombay)",10500000,"India","Federal Republic"],
    ["Seoul",9981619,"South Korea","Republic"],
    ["São Paulo",9968485,"Brazil","Federal Republic"],
    ["Shanghai",9696300,"China","PeoplesRepublic"],
    ["Jakarta",9604900,"Indonesia","Republic"],
    ["Karachi",9269265,"Pakistan","Republic"],
    ["Istanbul",8787958,"Turkey","Republic"],
    ["Ciudad de México",8591309,"Mexico","Federal Republic"],
    ["Moscow",8389200,"Russian Federation","Federal Republic"],
    ["New York",8008278,"United States","Federal Republic"]]
    ```

- `curl -X PUT -H "Content-Type: application/json" -d "{\"population\":5000}" http://localhost:9003/api/cities/3507`

