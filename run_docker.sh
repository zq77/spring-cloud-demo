namespace=z_q
registry=registry.cn-hangzhou.aliyuncs.com

function run_eureka () {
    docker-compose -f ./docker-compose.yml up -d eureka1
    docker-compose -f ./docker-compose.yml up -d eureka2
    # docker run --name=eureka1 -p "8761:8761" --env spring.profiles.active=eureka1 --link eureka2:eureka2 \
    #  -dt registry.cn-hangzhou.aliyuncs.com/z_q/eureka
    # docker run --name=eureka2 -p "8762:8761" --env spring.profiles.active=eureka2 --link eureka1:eureka1 \
    #  -dt registry.cn-hangzhou.aliyuncs.com/z_q/eureka
}

function run () {
    docker-compose -f ./docker-compose.yml up -d $1
}

cmds=( \

run_rabbitmq \
run_mariadb \
run_redis \
run_eureka \
run_config \
run_api_gateway \
run_product \
run_order \
run_user

)

function do_command () {

    case $1 in

        run_rabbitmq)
            run rabbitmq
            ;;
        
        run_mariadb)
            run mariadb
            ;;
        
        run_redis)
            run redis
            ;;

        run_eureka)
            run_eureka
            ;;

        run_config)
            run config
            ;;
        
        run_product)
            run product
            ;;

        run_api_gateway)
            run api-gateway
            ;;
            
        run_order)
            run order
            ;;

        run_user)
            run user
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