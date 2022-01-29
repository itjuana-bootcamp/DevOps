#! /usr/bin/env ruby

require "thor"

class Tools < Thor
  desc "hello NAME", "say hello to NAME"
  option :first_name, required: true
  option :last_name, required: true
  def hello
    puts "My name is #{args[:first_name]} #{args[:first_name]}"
  end
end
