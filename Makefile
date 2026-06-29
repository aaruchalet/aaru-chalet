.PHONY: \
	persistent-up \
	persistent-down \
	persistent-start \
	persistent-stop \
	persistent-restart \
	persistent-logs \
	persistent-shell \
	persistent-reset \
	temp-up \
	temp-down \
	temp-start \
	temp-stop \
	temp-restart \
	temp-logs \
	temp-shell \
	all-down \
	all-reset

########################################
# Persistent Database
########################################

persistent-up:
	docker compose -p dev --profile persistent up -d

persistent-down:
	docker compose -p dev --profile persistent down


persistent-start:
	docker compose -p dev --profile persistent start mysql

persistent-stop:
	docker compose -p dev --profile persistent stop mysql

persistent-restart:
	docker compose -p dev --profile persistent restart mysql

persistent-logs:
	docker compose -p dev logs -p persistent logs -f mysql

persistent-reset:
	docker compose -p dev --profile persistent down -v


########################################
# Temporary Database
########################################

temp-up:
	docker compose -p qa --profile temp up -d

temp-down:
	docker compose -p qa --profile temp down

temp-start:
	docker compose -p qa --profile temp start mysql-temp

temp-stop:
	docker compose -p qa --profile temp stop mysql-temp

temp-restart:
	docker compose -p qa --profile temp restart mysql-temp

temp-logs:
	docker compose -p qa logs -f mysql-temp

jenkins-up:
	docker compose -p dev --profile ci up -d


########################################
# Jenkins
########################################

jenkins-down:
	docker compose -p dev --profile ci down

jenkins-reset:
	docker compose -p dev --profile ci down -v


########################################
# All Containers start, stop, reset
########################################

all-up:
	docker compose -p dev --profile persistent up -d
	docker compose -p qa --profile temp up -d
	docker compose -p dev --profile ci up -d

all-down:
	docker compose -p dev down
	docker compose -p qa down

all-reset:
	docker compose -p dev down -v
	docker compose -p qa down -v

build-dev:
	./gradlew bootRun --args='--spring.profiles.active=dev'

build-qa:
	./gradlew bootRun --args='--spring.profiles.active=qa'