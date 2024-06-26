def call(String imageName, String context = '.'){
  dockerPush(imageName, context)
}

private void dockerPush(String imageName, String context) {
  def cmd = "docker push ${imageName} ${context}"
  echo "Executing: ${cmd}"
  sh cmd
}
