# DemoSQLCommenter

1. Create a [Google Cloud Platform](https://cloud.google.com/resource-manager/docs/creating-managing-projects) project
2. Create a [PostgreSQL instance](https://cloud.google.com/sql/docs/postgres/quickstart) in the above project
3. Configure */src/main/resources/application.properties* to point to the created PostgreSQL instance and use assigned username and password
4. Build dependencies with `gradle build`
5. Run program and enter sample data for new user then submit
6. Query should be visible in the [trace list](https://pantheon.corp.google.com/traces/list) with attributes exported
