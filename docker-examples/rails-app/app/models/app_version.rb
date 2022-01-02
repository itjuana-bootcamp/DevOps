class AppVersion < ApplicationRecord
  validates_presence_of :tag
  validates_uniqueness_of :tag
end
