def call() {
  sh "mvn clean package -DskipTests -Dcheckstyle.skip"
}
