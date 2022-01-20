- [Monitoring](#monitoring)
  - [Pre-requisites](#pre-requisites)
  - [Create a container to monitor](#create-a-container-to-monitor)
  - [Create a datadog account](#create-a-datadog-account)
  - [Install datadog agent in the server](#install-datadog-agent-in-the-server)
  - [Setup a host monitoring](#setup-a-host-monitoring)
  - [Update tags for better monitoring](#update-tags-for-better-monitoring)
  - [Setup a metric monitoring](#setup-a-metric-monitoring)
    - [Monitoring setup in datadog](#monitoring-setup-in-datadog)
    - [Simulate CPU load in the container](#simulate-cpu-load-in-the-container)
  - [Downtime for monitoing](#downtime-for-monitoing)
  - [References](#references)

# Monitoring

We will explore how to setup a host monitoring for a docker container. We will use an ubuntu server for this demo purpose.

## Pre-requisites

* [Docker](https://docs.docker.com/desktop/) installed
  * `docker --version` should show the docker version
* [Git](https://github.com/git-guides/install-git) installed
  * `git --version` should show the git version
* Have a [github account](https://github.com/join)


## Create a container to monitor

- Go to the github repository https://github.com/itjuana-bootcamp/DevOps
- Fork the repository

NOTE: From here on, whenever we say repository , that refers to your forked repository.

- Have docker desktop up and running.
- Clone the repository : `git clone git@github.com:<githubaccount>/DevOps.git`
- Go to the cloned repository and run the below commands.

  ```bash 
  cd monitoring/container_setup
  docker build -t monitoring .
  docker run --rm -d --name monitoring_demo monitoring
  docker exec -it monitoring_demo /bin/bash
  ```

## Create a datadog account 

- Go to datadog website for a [free trial](https://www.datadoghq.com/free-datadog-trial/)
- Create an account 
- Choose ubuntu as your agent OS 

## Install datadog agent in the server

- Under New Installation  --> Use our easy one-step install.
- Copy the command
- Go to the docker container monitor demo
- Paste the command and it will start installation of datadog agent.
- Once the installation is completed, 
- Check the status of the agent and ensure it is up and running

    ```bash
    sudo service datadog-agent status
    ```
- make a note of the hostname 
    ```bash
    hostname
    ```

## Setup a host monitoring

- Go to your datadog [home page](https://app.datadoghq.com/help/quick_start)
- Monitors --> New Monitor --> Host 
- In `Pick hosts by name or tag` , Choose the hostname of your server
- `Set alert conditions` - leave as is
- `Notify your team` - mention your mail ID
- `Say What's happening` - Give a title to the Monitor , and optionally some message.
- Click on `Test Notifications`
- Check your mail - you shoud receive a notification from datadog
- Save

**Nice!!! Now you have created your very first monitor** 

NOTE: The above mentioned way of host monitoring is great if we have a static IP / hostname for the servers. But, if you want to monitor dynamically changing containers , it would be a good idea to use tags. Let us see , how !

## Update tags for better monitoring
- Go to the docker container (if you are not already in)
```bash
docker exec -it monitoring_demo /bin/bash
```

- Stop the agent


```bash
sudo service datadog-agent stop
```

- Edit the file /etc/datadog-agent/datadog.yaml

```bash
vi /etc/datadog-agent/datadog.yaml
```

- search for tags ( what we are looking for is `# tags:`)
- Uncomment and enable tags (Be very careful of the spaces/ tabs. after all its YAML!!)
- Save file and exit
- Start the datadog agent

```bash
sudo service datadog-agent start
```
- Go to [datadog](https://app.datadoghq.com/help/quick_start)
- Manage Monitors - click on the monitor you created in the above steps.
- Edit
- In `Pick hosts by name or tag` , instead of host , you should now be able to see the tags we gave.
- Choose one or more of them
- Save

## Setup a metric monitoring

### Monitoring setup in datadog
- Go to [datadog](https://app.datadoghq.com/help/quick_start)
- Monitors --> New Monitor --> Metric
- `Define the metric` 
  - `a` - system.load.1
  - `from` - environment:dev
  - `avg by` - host
- `Set alert conditions` 
  - Alert threshold > 1 
- `Notify your team` - Give your maild ID 
- `Say what's happening` - Monitor title and optionally some message
- Save

### Simulate CPU load in the container
- Go to the docker container (if you are not already in)
```bash
docker exec -it monitoring_demo /bin/bash
```
- Increase CPU load
```bash
stress --cpu 3
```
- Go to the monitor you created in the above step
- Notice the load is going high 
- Check your mail - At this time you should be getting `[Triggered]` email from datadog
- Stop CPU load - `Ctrl + C`
- In some time, the alert should resolve on its own and you should get a `[Recovered]` mail.

## Downtime for monitoing
- Go to [datadog](https://app.datadoghq.com/help/quick_start)
- Monitors --> Manage Downtimes
- Click on `Schedule Downtime`
- Explore !!

NOTE: Once you are done with the lab, please do not forget to stop(`docker stop <containername>`) the container.

```bash
docker container ls
docker stop monitoring_demo
```

## References
- [Datadog documentation](https://docs.datadoghq.com/getting_started/)
- [Agent Usage Documentation](https://docs.datadoghq.com/agent/basic_agent_usage/ubuntu/?tab=agentv6v7)