from datetime import datetime
from flask_login import UserMixin

from powa_finance_app import db


class User(db.Model, UserMixin):
    __tablename__ = "users"
    id = db.Column(db.Integer, primary_key=True)
    username = db.Column(db.String(55), unique=True, nullable=False)
    email = db.Column(db.String(100), unique=True, nullable=False)
    password = db.Column(db.String(60), nullable=True)
    expenses = db.relationship("Expense", backref="user", lazy=True, cascade='all, delete-orphan')

    def to_json(self):
        return {
            'username': self.username,
            'email': self.email
        }


class Expense(db.Model, UserMixin):
    __tablename__ = "expense"
    id = db.Column(db.Integer, primary_key=True)
    amount = db.Column(db.Integer)
    date_added = db.Column(db.DateTime, nullable=False, default=datetime.utcnow)
    user_id = db.Column(db.Integer, db.ForeignKey("users.id"), nullable=False)

    def to_json(self):
        return {
            "amount": self.amount,
            "date_added": self.date_added,
            "user": self.user.username
        }
