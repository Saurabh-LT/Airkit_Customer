#if [ ! "$(docker ps -q -f name=selenium_hub)" ]; then
#  echo "Starting selenium docker container..."
#  docker-compose --compatibility up -d
#  sleep 5
#fi
#
#echo '##################################'
#echo 'docker container ips'
#docker ps -q | xargs -n 1 docker inspect --format '{{ .Name }} {{range .NetworkSettings.Networks}} {{.IPAddress}}{{end}}' | sed 's#^/##';
#echo '##################################'
#
#if [ $# -lt 1 ]; then
#    echo "Please specify the tags to run, e.g. './selenium.sh Login'"
#fi

#mvn clean test
mvn clean install -Dsurefire.suiteXmlFiles=LocalTestng.xml -DTag1="@$1" -DThreadCount="1"