def call(String dockerUsername = '', String registry = '', String dockerPassword = '') {
  sh "docker login --username ${dockerUsername} --password ${dockerPassword} ${registry}"
}
