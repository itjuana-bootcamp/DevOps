# Docker commands

## build the image
```bash
docker build -t node_app .
```

## Running the image and starting with a shell
```bash
docker run --rm -it node_app /bin/sh
```

## Listing images

```bash
docker images
```

## Remove all docker images

```bash
docker rmi -f $(docker images -q)
```

## Running nginx server

```bash
docker run --rm -it -p 3000:80 node_app
```
