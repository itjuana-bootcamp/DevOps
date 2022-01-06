HERE=$(shell pwd)

pg:
	docker run -d --rm --env-file=.env --name=pg -v $(HERE)/volumes/pg:/var/lib/postgresql/data postgres:14-alpine

build:
	docker build -t rails-app .

run:
	docker run --rm -it --env-file=.env --link=pg:pg -p 3000:3000 rails-app
