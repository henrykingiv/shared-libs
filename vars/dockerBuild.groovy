def call(String imageName, String context = '.'){
  dockerBuild(imageName, context)
}

private void dockerBuild(String imageName, String context) {
  def cmd = "docker build -t ${imageName} ${context}"
  echo "Executing: ${cmd}"
  sh cmd
}
