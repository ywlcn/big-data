# 説明


# セットアップ
1. DBについて、`./src/main/resources/db/*.sql`　をテーブルやテーブルデータを投入する。

1. `./src/main/resources/signite-server-config.xml`　を利用してサーバを起動する。
jarの配置


2. たまにサーバがinactive状態になる場合がある。その時に`apache-ignite-2.16.0\bin>control.bat --activate`を実施する。
3. `gradle bootrun`で起動する
4. 動作確認する


注意Point
- SQL文ではスキーマ名は`org.apache.ignite.configuration.CacheConfiguration`の名前となる。
  ```xml
      <bean class="org.apache.ignite.configuration.IgniteConfiguration">
          <property name="cacheConfiguration">
              <list>
                  <!-- Configuration for PersonCache -->
                  <bean class="org.apache.ignite.configuration.CacheConfiguration">
                      <property name="name" value="studentCache"/>   ★★★この名前となる
  ```

  - スキーマ名に["]と付ける必要
    ```sql
      SELECT * FROM \"studentCache\".person
    
    
    ```
    ```sql
  　　　sqlline.bat -u "jdbc:ignite:thin://127.0.0.1/" -n ignite -p ignite
　　　　select * from information_schema.tables     このコマンドからスキーマ名を確認できる

      | 2F791222-D95C-4170-9A07-3E8EBA2F4588 | studentCache      | PERSON                       | TABLE        | MEMORY       | CREATE MEMORY TABLE "studentCache".PERSON(
      _KEY INT INVISIBLE  NOT NULL,
      _VAL OTHER INVISIBLE ,
      NAME VARCHAR,
      ID INT, |
    ```

一つのCahcheには一つのテーブルのみLoadできるようです。　かつ　CacheConfigurationのNameと　JdbcTypeのcacheNameは一致する必要