from flask import Flask
from flask_migrate import Migrate
from flask_sqlalchemy import SQLAlchemy

from .config import config_map

db = SQLAlchemy()
migrate = Migrate()


def create_app(config_data=config_map["develop"]):
    app = Flask(__name__)
    app.config.from_object(config_data)

    db.init_app(app)
    migrate.init_app(app, db)

    from .main_app_api.routes import users
    app.register_blueprint(users)

    with app.app_context():
        db.create_all()

    return app
