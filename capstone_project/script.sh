docker build -t hello-world .
docker run --name hello-world -p 3000:3000 -itd hello-world
docker exec -it 603cdec10339 /bin/bash
