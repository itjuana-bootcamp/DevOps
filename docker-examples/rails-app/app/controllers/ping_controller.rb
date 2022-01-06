class PingController < ApplicationController
  def index
    version = AppVersion.last
    render status: :ok, json: { ok: true, version: version.tag }
  end
end
