class Dev:
    TESTING = True
    SQLALCHEMY_DATABASE_URI = "postgresql+psycopg2://daniilslobodeniuk@localhost:5432/powa_finance_flask"
    SQLALCHEMY_RECORD_QUERIES = True
    FLASKY_SLOW_DB_QUERY_TIME = 0.5
    SQLALCHEMY_TRACK_MODIFICATIONS = False
    WTF_CSRF_ENABLED = False


config_map = {
    "develop": Dev
}
