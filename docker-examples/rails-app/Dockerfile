FROM ruby:3.0.2-alpine

RUN apk update; apk upgrade; apk add --no-cache --upgrade vim postgresql-client build-base postgresql-dev tzdata; rm -rf /var/cache/apk/*

WORKDIR /app

COPY . .

ENV RAILS_ENV=production

RUN bundle

CMD /app/docker-entrypoint.sh
