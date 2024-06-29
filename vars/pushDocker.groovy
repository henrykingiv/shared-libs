def call(String imageName, String credentialsId = 'docker-creds', String toolName = 'docker') {
    pushDocker(imageName, credentialsId, toolName)
}

private void pushDocker(String imageName, String credentialsId, String toolName) {
    def majorVersion = '1'
    def buildNumber = env.BUILD_NUMBER.toInteger()
    def formattedBuildNumber = String.format('%02d', buildNumber)
    def imageTag = "${majorVersion}.${formattedBuildNumber}"
    sh "docker push ${imageName}:${imageTag}"
}
