from typing import Dict

from powa_finance_app import db
from powa_finance_app.models import User


def persists_user_data(request) -> None:
    data: Dict = request.json
    user = User()
    user.username = data.get("username", None)
    user.email = data.get("email", None)
    db.session.add(user)
    db.session.commit()
