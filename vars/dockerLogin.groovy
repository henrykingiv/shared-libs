def call(String docker-user = '', String registry = '', String docker-pass = '') {
  sh 'docker login --username ${docker-user} --password ${docker-pass} ${registry}'
}
