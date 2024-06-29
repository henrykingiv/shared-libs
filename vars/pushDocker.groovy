def call(String imageName, credentialsId: 'docker-creds', toolName: 'docker') {
  pushDocker(imageName, credentialsId, toolName)
}

private void pushDocker(String imageName, credentialsId, toolName) {
    def majorVersion = '1'
    def buildNumber = env.BUILD_NUMBER.toInteger()
    def formattedBuildNumber = String.format('%02d', buildNumber)
    def imageTag = "${majorVersion}.${formattedBuildNumber}"
    sh "docker push ${imageName}:${imageTag}"
}
