#!/usr/bin/env bash 

set -e  

# cd "$(dirname $0)"
root_folder=$(cd `dirname $0`; pwd)
cd $root_folder

function run() {
    cd $root_folder/$1
    mvn clean spring-boot:run
    # mvn clean package
#     java -jar target/*.jar
}

function run_with_multi_module() {
    cd $root_folder/$1
    # install depended module
    mvn -U clean install
    cd $2
    # run project
    mvn clean spring-boot:run 
}

function run_rabbitmq() {
    cd $root_folder
    docker-compose -f ./docker-compose.yml up -d rabbitmq
}

# add new cmd entry here 

cmds=( \ 

run_eureka \ 

run_config \

run_api_gateway \ 

run_eureka_client \ 

run_product \

run_product_quick \

run_order \ 

run_order_quick \ 

run_user \

run_user_quick \

run_rabbitmq

) 

function do_command () { 

    case $1 in 

        run_rabbitmq)
            run_rabbitmq
            ;;

        run_eureka) 
            run eureka 
            ;; 

        run_eureka_client) 
            run eureka-client 
            ;; 
        
        run_config)
            run config
            ;;

        run_product) 
            run_with_multi_module product server
            ;; 

        run_product_quick) 
            run product/server
            ;; 

        run_order) 
            run_with_multi_module order server
            ;; 

        run_order_quick) 
            run order/server
            ;; 

        run_user) 
            run_with_multi_module user server
            ;; 

        run_user_quick) 
            run user/server
            ;; 

        run_api_gateway)
            run api-gateway
            ;;

        *) 

            echo "Please select what you want to do:" 

            ;; 

    esac 

} 

 

# functional codes for this shell, you can ignore 

function select_cmd () { 

    echo "Please select what you want to do:" 

    select CMD in ${cmds[*]}; do 

        if [[  $(in_array $CMD ${cmds[*]}) = 0 ]]; then 

            do_command $CMD 

            break 

        fi 

    done 

} 
 
function select_arg () { 

    cmd=$1 

    shift 1 

    options=("$@") 

 

    echo "Please select which arg you want:" 

    select ARG in ${options[*]}; do 

        if [[  $(in_array ${ARG} ${options[*]}) = 0 ]]; then 

            ${cmd} ${ARG} 

            break 

        fi 

    done 

} 

function in_array () { 

    TARGET=$1 

    shift 1 

    for ELEMENT in $*; do 

        if [[ "$TARGET" == "$ELEMENT" ]]; then 

            echo 0 

            return 0 

        fi 

    done 

    echo 1 

    return 1 
} 

function main () { 
    if [[ $1 != "" && $(in_array $1 ${cmds[*]}) = 0 ]]; then 
        do_command $* 
    else 
        select_cmd 
    fi 
} 

main $* 
