def call(String docker-username = '', String registry = '', String docker-password = '') {
  sh 'docker login --username ${docker-username} --password ${docker-password} ${registry}'
}
