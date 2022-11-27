from typing import Dict

from flask import Blueprint, request, jsonify

from powa_finance_app.models import User
from powa_finance_app.service.database_operations import persists_user_data

users = Blueprint("users", __name__)


@users.route("/add-user", methods=["POST"])
def add_user() -> Dict:
    try:
        persists_user_data(request)
    except Exception as error:
        return jsonify({"error": error.args}, 400)
    else:
        return jsonify({"content": "Data has been persisted"}, 201)


@users.route("/get-user-info/<string:username>", methods=['GET'])
def get_user_info(username: str) -> Dict:
    user: User = User.query.filter_by(username=username).first()
    if not user:
        return jsonify({"error": f"No user found for username {username}"}, 400)
    return jsonify({"data": user.to_json()}, 200)
