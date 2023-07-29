namespace=z_q
registry=registry.cn-hangzhou.aliyuncs.com

function build_eureka () {
    cd eureka 
    mvn clean package
    docker_file=DockerFile

    tag=${registry}/${namespace}/eureka

    context_path=.

    docker build --force-rm \
         -f ${docker_file} \
         -t ${tag} \
         ${context_path}

    docker push ${tag}
}


function run_eureka () {
    docker run -p "8762:8761" -dt registry.cn-hangzhou.aliyuncs.com/z_q/eureka
}

cmds=( \

run_eureka \
build_eureka

)

function do_command () {

    case $1 in

       run_eureka)
           run_eureka
           ;;

        build_eureka)
            build_eureka
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