#if [ "$#" -eq 1 ]
#then
docker exec -t node1 curl http://172.17.0.4:8500$1
#else
#    echo "Please input the correct APIs format. For example command: /v1/status/leader"
#fi