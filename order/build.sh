namespace=z_q
registry=registry.cn-hangzhou.aliyuncs.com
mvn clean package
docker_file=DockerFile

tag=${registry}/${namespace}/order

context_path=.

docker build --force-rm \
     -f ${docker_file} \
     -t ${tag} \
     ${context_path}

docker push ${tag}
