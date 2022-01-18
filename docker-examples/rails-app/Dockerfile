FROM ruby:3.0.2-alpine

RUN apk update
RUN apk upgrade
RUN apk add --no-cache --upgrade postgresql-client \
    build-base \
    postgresql-dev \
    tzdata  
RUN rm -rf /var/cache/apk/*

WORKDIR /app

COPY . .

ENV RAILS_ENV=production

RUN bundle

CMD /app/docker-entrypoint.sh
