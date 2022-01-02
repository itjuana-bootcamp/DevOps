class CreateAppVersions < ActiveRecord::Migration[6.1]
  def change
    create_table :app_versions do |t|
      t.string :tag, limit: 10

      t.timestamps
    end
  end
end
