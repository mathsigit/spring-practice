# Consul on Docker Usage

## Create a consul cluster with 3 server node and 1 client node.

```shell script
./create_consul_cluster.sh
```
And you could check the leader via the command as below

```shell script
curl http://localhost:8500/v1/status/leader

#Getting the result means node1 be the leader
"172.17.0.2:8300"
```

UI
```shell script
http://localhost:8500/ui
```

## Check consul member

```shell script
./check_members.sh
```

## Get consul cluster ip of leader.

```shell script
./check_leader.sh
```

## Execute consul APIs

```shell script
./exec_curl.sh ${APIs Path}
```

For example: instead of checking leader via curl command `curl http://127.0.0.1:8500/v1/agent/checks`, you could execute `./exec_curl.sh /v1/agent/checks`
and you would get the same response: 
```json
{
  "service:redis": {
    "Node": "foobar",
    "CheckID": "service:redis",
    "Name": "Service 'redis' check",
    "Status": "passing",
    "Notes": "",
    "Output": "",
    "ServiceID": "redis",
    "ServiceName": "redis",
    "ServiceTags": ["primary"]
  }
}
```

## REF

* [Accessing consul UI running in docker on OSX](https://stackoverflow.com/questions/41228968/accessing-consul-ui-running-in-docker-on-osx)
* [Configuration of consul](https://www.consul.io/docs/agent/options.html)