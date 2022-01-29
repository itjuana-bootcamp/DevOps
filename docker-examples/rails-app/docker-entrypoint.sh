#! /bin/sh

set -e

rails db:migrate:status > /dev/null || rails db:setup
rails db:migrate
rails s -e production

