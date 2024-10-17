# 説明

# セットアップ

- DBの設定

  `./src/main/resources/db/*.sql`を利用してデータベースの構築する。DBの接続情報について、[igniteの設定ファイル]にあるので、あわせって修正する。

  ```xml
      <bean class="com.mysql.cj.jdbc.MysqlDataSource" id="mysqlDataSource">
          <property name="URL" value="jdbc:mysql://localhost:3306/ignite-db"/>
          <property name="user" value="root"/>
          <property name="password" value="123456"/>
      </bean>
  ```

- igniteサーバーの設定

  1. 起動時キャッシュをロードするために、ロードモジュールやDtoクラスをサーバへ事前に格納する。

     [00-Utils]プロジェクトをビルドして、生成したJarファイルはサーバーのLibフォルダに格納する。
     
2. `./src/main/resources/default-config.xml`を利用してサーバを起動する。
  
  3. たまにサーバがinactive状態になる場合がある。その時に`apache-ignite-2.16.0\bin>control.bat --activate`を実施する。
  
- クライアント側は`gradle bootrun`で起動する

  - `http://localhost:9004/mybatis`でアクセスして、下記のようなものが表示される

    ```json
    [{"studId":1,"name":"student_1","email":"student_1gmail.com","dob":1506524400000},{"studId":2,"name":"student_2","email":"student_2gmail.com","dob":1506524400000},{"studId":3,"name":"student_3","email":"student_3gmail.com","dob":1506524400000},
    ・・・
    {"studId":49,"name":"student_49","email":"student_49gmail.com","dob":1506524400000},{"studId":50,"name":"student_50","email":"student_50gmail.com","dob":1506524400000}]
    ```

# 注意ポイント

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
     SELECT * FROM \"studentCache\".student
    ```
    
  - スキーマ名は下記のような方法で確認できる
    
  ```sql
  > sqlline.bat -u "jdbc:ignite:thin://127.0.0.1/" -n ignite -p ignite
    select * from information_schema.tables     このコマンドからスキーマ名を確認できる
    
    ・・・
  | 2F791222-D95C-4170-9A07-3E8EBA2F4588 | studentCache      | PERSON                       | TABLE        | MEMORY       | CREATE MEMORY TABLE "studentCache".PERSON(
    _KEY INT INVISIBLE  NOT NULL,
    _VAL OTHER INVISIBLE ,
      NAME VARCHAR,
      ID INT, |
    ```

- 現時点で一つのキャッシュには二つのテーブルを読み込まないので、現在いったん二つのキャッシュを作成している。

  また、設定の問題かもJdbcTypeのcacheNameはCacheConfigurationのNameに一致する必要

