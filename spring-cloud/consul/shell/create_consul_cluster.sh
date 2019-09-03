
#HOST IP
HOSTIP=$(ifconfig | sed -En 's/127.0.0.1//;s/.*inet (addr:)?(([0-9]*\.){3}[0-9]*).*/\2/p')

#Starting 3 node with server mode(node1 -> 172.17.0.2, node2 -> 172.17.0.3 and node3 -> 172.17.0.4)

# To see more configuration on https://www.consul.io/docs/agent/options.html

# -client：The address to which Consul will bind client interfaces, including the HTTP and DNS servers. By default, this is "127.0.0.1", allowing only loopback connections
# -join：Address of another agent to join upon starting up. This can be specified multiple times to specify multiple agents to join.
# -node-id：Available in Consul 0.7.3 and later, this is a unique identifier for this node across all time, even if the name of the node or address changes. To see more on https://github.com/hashicorp/consul/issues/2877
# -node：The name of this node in the cluster. This must be unique within the cluster. By default this is the hostname of the machine.
# -bind：The address that should be bound to for internal cluster communications. This is an IP address that should be reachable by all other nodes in the cluster. By default, this is "0.0.0.0".
# -server：This flag is used to control if an agent is in server or client mode.
# -bootstrap-expect：This flag provides the number of expected servers in the datacenter.
docker run -d -e 'CONSUL_LOCAL_CONFIG={"skip_leave_on_interrupt": true}' --name=node1 -p 8600:8600 -p 8400:8400 -p 8300-8302:8300-8302 -p 8600:8600/udp -p 8301-8302:8301-8302/udp -h node1 consul:1.5.3 agent -server -bind=172.17.0.2  -bootstrap-expect=3 -node=node1
docker run -d -e 'CONSUL_LOCAL_CONFIG={"skip_leave_on_interrupt": true}' --name=node2 -h node2 consul:1.5.3 agent -server -bind=172.17.0.3  -join="$HOSTIP" -node-id=$(uuidgen | awk '{print tolower($0)}')  -node=node2
docker run -d -e 'CONSUL_LOCAL_CONFIG={"skip_leave_on_interrupt": true}' --name=node3 -h node3 consul:1.5.3 agent -server -bind=172.17.0.4  -join="$HOSTIP" -node-id=$(uuidgen | awk '{print tolower($0)}')  -node=node3

#Starting 1 client mode node, and be named node4 with ui
docker run -d -e 'CONSUL_LOCAL_CONFIG={"leave_on_terminate": true}' --name=node4 -p 8500:8500 -h node4 consul:1.5.3 agent -bind='{{ GetPrivateIP }}' -retry-join="$HOSTIP" -ui -client=0.0.0.0 -node-id=$(uuidgen | awk '{print tolower($0)}') -node=node4