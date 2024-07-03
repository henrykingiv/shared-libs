// def call() {
//   sh "mvn clean package -DskipTests -Dcheckstyle.skip"
// }

def call(String mavenGoals = 'clean package', String mavenOpts = '-DskipTests -Dcheckstyle.skip') {
  sh "mvn ${mavenGoals} ${mavenOpts}"
}
