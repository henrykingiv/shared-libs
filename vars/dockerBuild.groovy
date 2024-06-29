def call(String imageName){
  dockerBuild(imageName)
}

private void dockerBuild(String imageName) {
  def majorVersion = '1'
  def buildNumber = env.BUILD_NUMBER.toInteger()
  def formattedBuildNumber = String.format('%02d', buildNumber)
  def imageTag = "${majorVersion}.${formattedBuildNumber}"
  def cmd = "docker build -t ${imageName}:${imageTag}"
  echo "Executing: ${cmd}"
  sh cmd
}
