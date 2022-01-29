FROM ubuntu:20.04

RUN apt-get update  -y \
    && apt-get upgrade -y \ 
    && apt-get install -y \
    ssh \
    sshpass \
    sudo \
    stress \
    curl \
    vim \
    software-properties-common

COPY startup.sh .

CMD ["/bin/bash", "startup.sh"]
