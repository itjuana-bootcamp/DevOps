require "test_helper"

class AppVersionTest < ActiveSupport::TestCase
  test "valid tag" do
    version = AppVersion.new
    version.tag = 'v0.0.0'
    assert version.valid?
  end

  test "tag is require" do
    version = AppVersion.new
    assert_not version.valid?
  end

  test "tag is unique" do
    version = AppVersion.new
    version.tag = 'v0.0.0'
    assert version.save
    version_two = AppVersion.new
    version_two.tag = 'v0.0.0'
    assert_not version_two.valid?
  end
end
